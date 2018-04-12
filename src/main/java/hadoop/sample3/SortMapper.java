package hadoop.sample3;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SortMapper extends Mapper<LongWritable,Text,Spead,Text>{
    Text text = new Text();
    IntWritable intWritable = new IntWritable();
    Spead spead = new Spead();
    @Override
    public void map(LongWritable key,Text value,Context context) throws IOException, InterruptedException {
        String[] split = value.toString().split("\t");
        String name = split[0];
        int money = Integer.parseInt(split[1]);
        text.set(name);
        intWritable.set(money);
        spead.set(text,intWritable);

        context.write(spead,text);
    }
}
