package hadoop.sample5;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SortStoryMapper extends Mapper<LongWritable,Text,LongWritable,Text>{
    Text text = new Text();
    LongWritable longWritable = new MyLongWritable();
    @Override
    public void map(LongWritable key,Text value,Context context) throws IOException, InterruptedException {
        String[] split = value.toString().split("\t");
        text.set(split[0]);
        longWritable.set(Long.parseLong(split[1]));

        context.write(longWritable,text);
    }
}
