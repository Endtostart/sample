package hadoop.sample5;

import hadoop.sample3.SortMapper;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class SortStory extends Configured implements Tool{
    /**
     * 用于处理sample4中产生的数据,对数据进行倒序排列
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int returnValue = ToolRunner.run(new SortStory(),args);
        System.exit(returnValue);
    }

    @Override
    public int run(String[] args) throws Exception {
        if(args.length != 2){
            return -1;
        }

        Job job = new Job();
        job.setJarByClass(SortStory.class);
        job.setMapperClass(SortStoryMapper.class);
        job.setReducerClass(SortStoryReduce.class);

        job.setMapOutputKeyClass(MyLongWritable.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(MyLongWritable.class);

        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        int returnValue = job.waitForCompletion(true)? 0 : 1;
        if(job.isSuccessful()){
            System.out.println("Job was Successful.");
        }else if(!job.isSuccessful()){
            System.out.println("Job was not Successful");
        }
        return returnValue;
    }
}
