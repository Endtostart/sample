package hadoop.sample4;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class StoryMapper extends Mapper<LongWritable,Text,Text,LongWritable>{
    private Text text = new Text();
    private LongWritable one = new LongWritable(1);
    @Override
    public void map(LongWritable key,Text value,Context context) throws IOException, InterruptedException {
        String line = value.toString().trim();
        if(!StringUtils.isBlank(line)){
            Result parse = ToAnalysis.parse(line);
            List<Term> termList = parse.getTerms();
            Iterator<Term> iterator = termList.iterator();
            while(iterator.hasNext()){
                text.set(iterator.next().getName());
                context.write(text,one);
            }
        }
    }
}
