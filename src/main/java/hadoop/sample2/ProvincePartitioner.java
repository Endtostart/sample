package hadoop.sample2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

import java.util.HashMap;
import java.util.Map;

public class ProvincePartitioner extends Partitioner<Text,SpendBean>{
    private static Map<String,Integer> provinces = new HashMap();
    static {
        provinces.put("江西",0);
        provinces.put("广东",1);
        provinces.put("北京",2);
        provinces.put("湖南",3);
        provinces.put("上海",4);
        provinces.put("西藏",5);
    }


    @Override
    public int getPartition(Text text, SpendBean spendBean, int i) {
        Integer provience = provinces.get(spendBean.getProvience().toString());
        provience = provience == null ? 6 : provience;
        return provience;
    }
}
