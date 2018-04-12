package hadoop.sample3;

import org.apache.hadoop.mapreduce.Reducer;

import javax.xml.soap.Text;
import java.io.IOException;

public class SortReducer extends Reducer<Spead,Text,Text,Spead>{
    @Override
    public void reduce(Spead key,Iterable<Text> values,Context context) throws IOException, InterruptedException {
        context.write(values.iterator().next(),key);
    }
}
