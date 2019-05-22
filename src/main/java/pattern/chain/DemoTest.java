package pattern.chain;

import java.util.ArrayList;
import java.util.List;

public class DemoTest {
    public static void main(String[] args) {
        Filter filter1 = new GeneralFilter("System");
        Filter filter2 = new GeneralFilter("System");
        Filter filter3 = new GeneralFilter("System");

        MyFilter personal = new MyFilter("personal");
        Filter personal2 = new GeneralFilter("personal");
        Filter personal3 = new GeneralFilter("personal");

        List<Filter> filters = new ArrayList<>();
        filters.add(filter1);
        filters.add(personal);
        filters.add(filter2);
        filters.add(filter3);

        List<Filter> personals = new ArrayList<>();
        personals.add(personal2);
        personals.add(personal3);
        personal.setFilters(personals);
        FilterChain chain = DefaultFilterChain.init(filters);
        chain.doFilter("hello", "bye");
    }

}
