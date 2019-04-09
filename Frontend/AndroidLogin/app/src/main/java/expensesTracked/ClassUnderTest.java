package expensesTracked;

public class ClassUnderTest {
    Context mContext;
    public ClassUnderTest(Context context) {
        mContext = context;
    }
    public String getHelloWorldString() {
        return mContext.getString(R.string.text_hello_word);
    }
}
