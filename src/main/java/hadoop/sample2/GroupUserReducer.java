package hadoop.sample2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class GroupUserReducer extends Reducer<Text,SpendBean,Text,SpendBean>{

    @Override
    public void reduce(Text key, Iterable<SpendBean> values,Context context) throws IOException, InterruptedException {
        int money = 0;
        Text province = null;
        for(SpendBean bean : values){
            money += bean.getMoney().get();
            if(province == null){
                province = bean.getProvience();
            }
        }
        context.write(key,new SpendBean(key,new IntWritable(money),province));
    }
}
