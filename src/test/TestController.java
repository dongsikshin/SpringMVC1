package test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	//3,4�ܰ踦 ������ ��, ���� ��Ʈ�ѷ��� ModelAndView, String, ���� ��ȯ�ϸ� 
	//�� ��ȯ�� ������� �̿��Ͽ� � �������� ���������� �������ִ� �ڰ� �ٷ� 
	//ViewResolver �̴�!! �� ���� ��Ʈ�ѷ��� ViewResolver�� ���ؼ�, �����������
	//�����ش�!!
	@RequestMapping("/test.do")
	public ModelAndView execute(){
		System.out.println(this.getClass().getName()+" �ҷ���?");
		
		//Model�� View�� ������ �����͸� ��Ե� ��ü  request.setAttribute()ȿ���͵���
		//View �� ������ ���� �������� ���� Ű��...
		ModelAndView mav = new ModelAndView();
		mav.setViewName("test/result");		
		return mav;
	}
}






