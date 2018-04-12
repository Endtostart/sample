package hadoop.sample6;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;
import java.util.Iterator;

public class Friend1 extends Configured implements Tool{
    /**
     * 计算是本人是多少人的好友
     */
    static class FriendMapper extends Mapper<LongWritable,Text,Text,Text>{
        private Text k = new Text();
        private Text v = new Text();
        @Override
        public void map(LongWritable key,Text value,Context context) throws IOException, InterruptedException {
            String[] split = value.toString().split(":");
            k.set(split[0]);
            for(String friend : split[1].split(",")){
                v.set(friend);
                context.write(v,k);
            }
        }
    }

    static class FriendReduce extends Reducer<Text,Text,Text,Text>{
        private Text v = new Text();
        @Override
        public void reduce(Text key,Iterable<Text> values,Context context) throws IOException, InterruptedException {
            Iterator<Text> iterator = values.iterator();
            StringBuffer sb = new StringBuffer();
            while(iterator.hasNext()){
                sb.append(iterator.next()).append(",");
            }
            v.set(sb.toString());
            context.write(key,v);
        }
    }

    public static void main(String[] args) throws Exception {
        int returnValue = ToolRunner.run(new Friend1(),args);
        System.exit(returnValue);
    }

    @Override
    public int run(String[] args) throws Exception {
        if(args.length != 2){
            return -1;
        }

        Job job = new Job();
        job.setJarByClass(Friend1.class);
        job.setMapperClass(FriendMapper.class);
        job.setReducerClass(FriendReduce.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        int returnValue = job.waitForCompletion(true) ? 0:1;
        if(job.isSuccessful()){
            System.out.println("Job was Successful");
        }else if(!job.isSuccessful()){
            System.out.println("Job was not Successful");
        }

        return returnValue;
    }
}
