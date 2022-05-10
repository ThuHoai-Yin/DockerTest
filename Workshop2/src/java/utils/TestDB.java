package utils;

public class TestDB {
    public static void main(String[] args) throws Exception {
        DBContext.getConnection();
        DataAccessObject.addCategory("kk", "kk");
        System.out.println(DataAccessObject.getListCategory());
    }    
}
