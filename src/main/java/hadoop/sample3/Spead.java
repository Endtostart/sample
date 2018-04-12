package hadoop.sample3;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Spead implements WritableComparable<Spead>{
    private Text name;
    private IntWritable money;

    public Spead(){}
    public Spead(Text name,IntWritable money){
        this.name = name;
        this.money = money;
    }

    public void set(Text name,IntWritable money){
        this.name = name;
        this.money = money;
    }
    @Override
    public int compareTo(Spead o) {
        return this.getMoney().get() - o.getMoney().get();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        name.write(dataOutput);
        money.write(dataOutput);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        name = new Text();
        name.readFields(dataInput);
        money = new IntWritable();
        money.readFields(dataInput);
    }

    public Text getName() {
        return name;
    }

    public void setName(Text name) {
        this.name = name;
    }

    public IntWritable getMoney() {
        return money;
    }

    public void setMoney(IntWritable money) {
        this.money = money;
    }

    @Override
    public String toString(){
        return this.getName().toString()+"\t"+this.getMoney().get();
    }
}
