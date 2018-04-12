package hadoop.sample2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class GroupUserMapper extends Mapper<LongWritable,Text,Text,SpendBean>{
    @Override
    public void map(LongWritable key,Text value,Context context) throws IOException, InterruptedException {
        String val = value.toString();
        String[] split = val.split("\t");

        String name = split[0];
        String province = split[1];
        String type = split[2];
        int money = Integer.parseInt(split[3]);

        SpendBean spendBean = new SpendBean();
        spendBean.setUserName(new Text(name));
        spendBean.setMoney(new IntWritable(money));
        spendBean.setProvience(new Text(province));

        context.write(new Text(name),spendBean);
    }
}
