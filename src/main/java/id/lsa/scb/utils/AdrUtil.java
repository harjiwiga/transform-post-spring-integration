    package id.lsa.scb.utils;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    /**
     * Created by harji on 5/25/16.
     */
    public class AdrUtil {

        private static AdrUtil instance = null;

        private String sourceRootDir;
        public List<Adr> adrs = new ArrayList<Adr>();

        private AdrUtil(){
        }

        public static synchronized AdrUtil getInstance(){
            if (instance == null)
                instance = new AdrUtil();
            return instance;
        }

        public String getSourceRootDir() { return sourceRootDir; }

        public void setSourceRootDir(String sourceRootDir) { this.sourceRootDir = sourceRootDir; }

        public List<Adr> getAdrs() {
            return adrs;
        }

        public void setAdrs(List<Adr> adrs) {

            this.adrs = adrs;
        }

        public void addAdrs(Adr adr) {
            adrs.add(adr);
        }

        public void clearAdrs() {
            adrs = new ArrayList<Adr>();
        }

    }
