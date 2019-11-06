/**
 * @Author: senne
 * @Date: 2019/9/24 13:40
 * @Version 1.0
 */
public class FormServiceImpl implements FormService {
    @Override
    public void removeTopic(Integer topicId) {
        System.out.println("模拟删除topic记录：" + topicId);
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void removeForm(Integer formId) {
        System.out.println("模拟删除form记录：" + formId);
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
