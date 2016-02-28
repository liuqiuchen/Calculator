package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
	private Button btn_0;//0���ְ�ť
	private Button btn_1;//1���ְ�ť
	private Button btn_2;//2���ְ�ť
	private Button btn_3;//3���ְ�ť
	private Button btn_4;//4���ְ�ť
	private Button btn_5;//5���ְ�ť
	private Button btn_6;//6���ְ�ť
	private Button btn_7;//7���ְ�ť
	private Button btn_8;//8���ְ�ť
	private Button btn_9;//9���ְ�ť
	private Button btn_dot;//dot��ť
	private Button btn_del;//ɾ����ť
	private Button btn_c;//�����ť
	private Button btn_add;//+��ť
	private Button btn_subtract;//-��ť
	private Button btn_multiply;//*��ť
	private Button btn_divide;//�°�ť
	private Button btn_equal;//=��ť
	
	private EditText et_input;//��ʾ�������ݵ���ʾ��
	
	//private boolean clear_flag;//������ձ�ʶ
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //ʵ������ť�������
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_dot = (Button) findViewById(R.id.btn_dot);
        btn_del = (Button) findViewById(R.id.btn_del);
        btn_c = (Button) findViewById(R.id.btn_c);
        btn_add = (Button) findViewById(R.id.btn_addition);
        btn_subtract = (Button) findViewById(R.id.btn_subtract);
        btn_multiply = (Button) findViewById(R.id.btn_multiply);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        
        et_input = (EditText) findViewById(R.id.et_input);
        
        //������ť�ĵ���¼�
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_c.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_subtract.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
    }
    
    //��дonclick����
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		//�õ���ʾ��������
		String str = et_input.getText().toString();
		
		//�жϵ�ǰ��������ĸ���ť
		switch (v.getId()) {
		//���ְ�ť
		case R.id.btn_0:
		case R.id.btn_1:
		case R.id.btn_2:
		case R.id.btn_3:
		case R.id.btn_4:
		case R.id.btn_5:
		case R.id.btn_6:
		case R.id.btn_7:
		case R.id.btn_8:
		case R.id.btn_9:
		case R.id.btn_dot:	
			/*//�����ť��ʱ����Ҫ���
			if(clear_flag){
	    		clear_flag = false;
	    		et_input.setText("");
	    	}*/
			//��view�ؼ�ת��ΪButton�ؼ�,�����Ϳ���ʹ��Button�ؼ���ص�������
			//((Button)v).getText()������String���ͣ�Ӧ�ð���ת��Ϊ�ַ�����
			//�����ǣ�((Button)v).getText().toString();
			et_input.setText(str + ((Button)v).getText().toString());
			break;
		//�����
		case R.id.btn_addition:	
		case R.id.btn_subtract:
		case R.id.btn_multiply:
		case R.id.btn_divide:
			/*//�����ť��ʱ����Ҫ���
			if(clear_flag){
	    		clear_flag = false;
	    		et_input.setText("");
	    	}*/
			//��������������ǰ�����һ���ո�
			et_input.setText(str + " " + ((Button)v).getText().toString() + " ");
			break;
		//���ⰴť
		case R.id.btn_del:
			/*//�����ť��ʱ����Ҫ���
			if(clear_flag){
	    		clear_flag = false;
	    		et_input.setText("");
	    	}else*/ if((str != null) || (str == "")){//ɾ����һ��һ����ɾ��
				et_input.setText(str.substring(0, str.length() - 1));
			}
			break;
		case R.id.btn_c:
			/*//�����ť��ʱ����Ҫ���
	    	clear_flag = false;*/
			//������������
			et_input.setText("");
			break;
		//���ڰ�ť
		case R.id.btn_equal:
			getResult();
			break;
		default:
			break;
		}
	}

	//�ȺŰ�ť����дһ������
	/*
	 * ������*/
    private void getResult(){
    	/*//�����ֹһ�ε���Ⱥ�
    	if(clear_flag){
    		clear_flag = false;
    		return;
    	}
    	//����Ⱥŵ�ʱ����ձ�ʶΪtrue
    	clear_flag = false;*/
    	
    	//�õ���ʾ���������
    	String content = et_input.getText().toString();
    	if((content == null) || (content == "")){
    		return;
    	}
    	
    	//ÿ���Ӽ��˳�����ǰ�涼��һ������ı�־�����ǿո�
    	//�жϵ�ǰ���������Ƿ��пո�
    	if(!content.contains(" ")){
    		return;//ֱ��return��û�����������������
    	}
    	
    	//����һ��double���͵�result
    	double result = 0;
    	
    	//�пո�ͽ�ȡ���������
    	String s1 = content.substring(0, content.indexOf(" "));//�����ǰ����Ǹ��ַ���
    	String s2 = content.substring(content.indexOf(" ") + 1, content.indexOf(" ") + 2);//��ȡ���������
    	String s3 = content.substring(content.indexOf(" ") + 3);//�����������Ǹ��ַ�
    	
    	//������߶���Ϊ��
    	if(!s1.equals("") && !s3.equals("")){
    		//ǿ��ת��
    		double d1 = Double.parseDouble(s1);
    		double d2 = Double.parseDouble(s3);
    		
    		if(s2.equals("+")){
    			result = d1 + d2;
    		}else if(s2.equals("-")){
    			result = d1 - d2;
    		}else if(s2.equals("*")){
    			result = d1 * d2;
    		}else if(s2.equals("/")){
    			if(d2 == 0){
    				result = 0;
    			}else{
    				result = d1 / d2;
    			}
    		}
    		
    		if(!s1.contains(".") && !s3.contains(".")){
    			int r = (int) result;
    			et_input.setText(r + "");
    		}else{
    			et_input.setText(result + "");
    		}
    		
    	}else if(!s1.equals("") && s3.equals("")){
    		
    		et_input.setText(content);
    		
    	}else if(s1.equals("") && !s3.equals("")){
    		
    		//ǿ��ת��
    		double d2 = Double.parseDouble(s3);
    		
    		if(s2.equals("+")){
    			result = 0 + d2;
    		}else if(s2.equals("-")){
    			result = 0 - d2;
    		}else if(s2.equals("*")){
    			result = 0;
    		}else if(s2.equals("/")){
    			result = 0;
    		}
    		
    		if(!s1.contains(".") && !s3.contains(".")){
    			int r = (int) result;
    			et_input.setText(r + "");
    		}else{
    			et_input.setText(result + "");
    		}
    	
    	//���߶�Ϊ��
    		
    	}else{
    		et_input.setText("");
    	}
    		
    }

}



































