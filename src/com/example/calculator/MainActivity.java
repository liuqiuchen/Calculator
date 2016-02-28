package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
	private Button btn_0;//0数字按钮
	private Button btn_1;//1数字按钮
	private Button btn_2;//2数字按钮
	private Button btn_3;//3数字按钮
	private Button btn_4;//4数字按钮
	private Button btn_5;//5数字按钮
	private Button btn_6;//6数字按钮
	private Button btn_7;//7数字按钮
	private Button btn_8;//8数字按钮
	private Button btn_9;//9数字按钮
	private Button btn_dot;//dot按钮
	private Button btn_del;//删除按钮
	private Button btn_c;//清除按钮
	private Button btn_add;//+按钮
	private Button btn_subtract;//-按钮
	private Button btn_multiply;//*按钮
	private Button btn_divide;//÷按钮
	private Button btn_equal;//=按钮
	
	private EditText et_input;//显示输入内容的显示屏
	
	//private boolean clear_flag;//定义清空标识
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //实例化按钮和输入框
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
        
        //监听按钮的点击事件
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
    
    //重写onclick方法
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		//得到显示屏的内容
		String str = et_input.getText().toString();
		
		//判断当前点击的是哪个按钮
		switch (v.getId()) {
		//数字按钮
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
			/*//点击按钮的时候需要清空
			if(clear_flag){
	    		clear_flag = false;
	    		et_input.setText("");
	    	}*/
			//把view控件转化为Button控件,这样就可以使用Button控件相关的属性了
			//((Button)v).getText()并不是String类型，应该把其转换为字符串，
			//方法是：((Button)v).getText().toString();
			et_input.setText(str + ((Button)v).getText().toString());
			break;
		//运算符
		case R.id.btn_addition:	
		case R.id.btn_subtract:
		case R.id.btn_multiply:
		case R.id.btn_divide:
			/*//点击按钮的时候需要清空
			if(clear_flag){
	    		clear_flag = false;
	    		et_input.setText("");
	    	}*/
			//方便运算清晰，前后各加一个空格
			et_input.setText(str + " " + ((Button)v).getText().toString() + " ");
			break;
		//特殊按钮
		case R.id.btn_del:
			/*//点击按钮的时候需要清空
			if(clear_flag){
	    		clear_flag = false;
	    		et_input.setText("");
	    	}else*/ if((str != null) || (str == "")){//删除是一个一个地删除
				et_input.setText(str.substring(0, str.length() - 1));
			}
			break;
		case R.id.btn_c:
			/*//点击按钮的时候需要清空
	    	clear_flag = false;*/
			//清空输入框内容
			et_input.setText("");
			break;
		//等于按钮
		case R.id.btn_equal:
			getResult();
			break;
		default:
			break;
		}
	}

	//等号按钮单独写一个方法
	/*
	 * 运算结果*/
    private void getResult(){
    	/*//如果不止一次点击等号
    	if(clear_flag){
    		clear_flag = false;
    		return;
    	}
    	//点击等号的时候，清空标识为true
    	clear_flag = false;*/
    	
    	//得到显示屏里的内容
    	String content = et_input.getText().toString();
    	if((content == null) || (content == "")){
    		return;
    	}
    	
    	//每个加减乘除符号前面都有一个特殊的标志，就是空格
    	//判断当前内容里面是否有空格
    	if(!content.contains(" ")){
    		return;//直接return，没有运算符，不用运算
    	}
    	
    	//定义一个double类型的result
    	double result = 0;
    	
    	//有空格就截取输入的数字
    	String s1 = content.substring(0, content.indexOf(" "));//运算符前面的那个字符串
    	String s2 = content.substring(content.indexOf(" ") + 1, content.indexOf(" ") + 2);//截取到的运算符
    	String s3 = content.substring(content.indexOf(" ") + 3);//运算符后面的那个字符
    	
    	//如果两者都不为空
    	if(!s1.equals("") && !s3.equals("")){
    		//强制转换
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
    		
    		//强制转换
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
    	
    	//两者都为空
    		
    	}else{
    		et_input.setText("");
    	}
    		
    }

}



































