package util;

/*
 * �ص�������������������������ؽ��
 */

public interface HttpCallBackListener {//�ӿڲ����з�����

	void onFinish(String response);//����Ϊ���ص�����
	
	void onError(Exception e);//����Ϊ������Ϣ

}
