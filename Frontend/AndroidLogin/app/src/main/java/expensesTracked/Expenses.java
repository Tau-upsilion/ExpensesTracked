package expensesTracked;

public class Expenses {
    
    private Integer id;
    
    private String description;
    
    private String category;
    
    private String expensesName;
    
    private int userId;
    
    private String amount;
    
    private String token;
    
    private boolean error;
    
    private String error_msg;
    
    public Expenses(String description, String category, String expensesName, String amount, String token) {
        this.description = description;
        this.category = category;
        this.expensesName = expensesName;
        this.amount = amount;
        this.token = token;
        this.error = false;
    }
    public void setId(Integer i) {
        this.id = i;
    }
    public Integer getId() {
        return this.id;
    }
    public void setExpensesname(String n) {
        this.expensesName = n;
    }
    public void setAmount(String m) {
        this.amount = m;
    }
    public String getAmount() {
        return this.amount;
    }
    public String getExpensesName() {
        return this.expensesName;
    }
    public int getUserID() {
        return this.userId;
    }
    public void setUserID(int i) {
        this.userId = i;
    }
    public String getToken() {
        return this.token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String randomToken() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        
        int lower = 10;
        int upper = 20;
        
        int n = (int) (Math.random() * (upper - lower)) + lower;
        
        StringBuilder sb = new StringBuilder(n);
        
        for (int i = 0; i < n; i++)
        {
            int index = (int) ((int) characters.length() * Math.random());
            
            sb.append(characters.charAt(index));
        }
        token = sb.toString();
        return token;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    
    public boolean isError() {
        return error;
    }
    
    public void setError(boolean error) {
        this.error = error;
    }
    
    public String getError_msg() {
        return error_msg;
    }
    
    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }
    
}
