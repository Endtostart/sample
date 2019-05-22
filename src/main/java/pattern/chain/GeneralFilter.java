package pattern.chain;

import java.util.Objects;

public class GeneralFilter implements Filter {

    private String name;

    public GeneralFilter(String name) {
        this.name = name;
    }

    @Override
    public void init() {
        if (Objects.isNull(name)) {
            this.name = this.hashCode() + "";
        } else {
            this.name = this.hashCode() + " == " + name;
        }
    }

    @Override
    public void doFilter(String req, String res, FilterChain chain) {
        System.out.println("id:" + name + "\tGeneralFilter: === >req:" + req + " & res:" + res);
        chain.doFilter(req, res);
        System.out.println("id:"+name+"\tGeneralFilter: ====> after");
    }
}
