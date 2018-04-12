package hadoop.sample2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class SpendBean implements Writable {
    private Text userName;
    private IntWritable money;
    private Text provience;

    public SpendBean(Text userName,IntWritable money,Text provience){
        this.userName = userName;
        this.money = money;
        this.provience = provience;
    }

    /**
     * 反序列化时必须有一个空参的构造方法
     */
    public SpendBean(){}

    /**
     * 序列化的代码
     * @param out
     */
    @Override
    public void write(DataOutput out) throws IOException {
        userName.write(out);
        money.write(out);
        provience.write(out);
    }

    /**
     * 反序列化的代码
     * @param in
     */
    public void readFields(DataInput in) throws IOException {
        userName = new Text();
        userName.readFields(in);
        money = new IntWritable();
        money.readFields(in);
        provience = new Text();
        provience.readFields(in);
    }

    public Text getUserName() {
        return userName;
    }

    public void setUserName(Text userName) {
        this.userName = userName;
    }

    public IntWritable getMoney() {
        return money;
    }

    public void setMoney(IntWritable money) {
        this.money = money;
    }

    public Text getProvience() {
        return provience;
    }

    public void setProvience(Text provience) {
        this.provience = provience;
    }

    @Override
    public String toString(){
        return "{name: "+userName.toString()+" money: "+money.get()+" provience: "+provience.toString();
    }
}
