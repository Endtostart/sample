package hadoop.sample4;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.OutputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;

public class StoryWord extends Configured implements Tool{
    /**
     * 计算一本小说中词汇出现的次数(无顺)
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int returnValue = ToolRunner.run(new StoryWord(),args);
        System.exit(returnValue);
    }

    @Override
    public int run(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if(args.length != 2){
            return -1;
        }

        Job job = new Job();
        job.setJarByClass(StoryWord.class);
        job.setMapperClass(StoryMapper.class);
        job.setReducerClass(StoryReducer.class);
        job.setCombinerClass(StoryCombiner.class);

        job.setMapOutputValueClass(LongWritable.class);
        job.setMapOutputKeyClass(Text.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        int returnValue = job.waitForCompletion(true) ? 0 : 1;
        if(job.isSuccessful()){
            System.out.println("Job was Successful.");
        }else if(!job.isSuccessful()){
            System.out.println("Job was not Successful.");
        }
        return  returnValue;
    }
}
