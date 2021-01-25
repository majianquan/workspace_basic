package adapter.demo4;

public class Client {
    public static void main(String[] args) {
        AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() {
            @Override
            public void noAnimationStart(Animator animation) {
                animation.beforeStart();
                System.out.println("开始运行...");
                super.noAnimationStart(animation);
            }
        };
        animatorListenerAdapter.noAnimationStart(new Animator() {
            @Override
            public void beforeStart() {
                System.out.println("beoferStart");
            }
        });
    }
}
