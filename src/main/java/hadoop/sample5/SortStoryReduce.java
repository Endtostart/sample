package hadoop.sample5;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class SortStoryReduce extends Reducer<MyLongWritable,Text,Text,MyLongWritable>{
    @Override
    public void reduce(MyLongWritable key,Iterable<Text> values,Context context) throws IOException, InterruptedException {
        context.write(values.iterator().next(),key);
    }

}
