package hadoop.sample4;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class StoryCombiner extends Reducer<Text,LongWritable,Text,LongWritable>{
    LongWritable longWritable = new LongWritable();
    @Override
    protected void reduce(Text key,Iterable<LongWritable> values,Context context) throws IOException, InterruptedException {
        Iterator<LongWritable> iterator = values.iterator();
        int sum = 0;
        while(iterator.hasNext()){
            sum += iterator.next().get();
        }
        longWritable.set(sum);
        context.write(key,longWritable);
    }
}
