package hadoop.sample2;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class GroupUser {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);

        job.setJarByClass(GroupUser.class);

        job.setMapperClass(GroupUserMapper.class);
        job.setReducerClass(GroupUserReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(SpendBean.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(SpendBean.class);
        job.setPartitionerClass(ProvincePartitioner.class);
        job.setNumReduceTasks(7);

        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        int returnValue = job.waitForCompletion(true) ? 0 : 1;
        if(job.isSuccessful()){
            System.out.println("Job was Successful");
        }else if(!job.isSuccessful()){
            System.out.println("Job was not Successful");
        }

        System.exit(returnValue);
    }
}

