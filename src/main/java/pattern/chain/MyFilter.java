package pattern.chain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyFilter implements Filter {

    private String name;

    private List<Filter> filters = new ArrayList<>();

    public MyFilter(String name) {
        this.name = name;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
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
        new VutrlFilterChain(chain, this.filters).doFilter(req, res);
    }

    private class VutrlFilterChain implements FilterChain{

        private FilterChain originalFlterChain;
        private List<Filter> personalFilter = new ArrayList<>();
        private int currentPostion = 0;

        public VutrlFilterChain(FilterChain originalFlterChain, List<Filter> personalFilter) {
            this.originalFlterChain = originalFlterChain;
            this.personalFilter = personalFilter;
        }

        @Override
        public void doFilter(String req, String res) {
            if (currentPostion == personalFilter.size()) {
                originalFlterChain.doFilter(req, res);
            } else {
                currentPostion++;
                Filter filter = personalFilter.get(currentPostion-1);
                filter.doFilter(req, res,this);
            }
        }
    }
}
