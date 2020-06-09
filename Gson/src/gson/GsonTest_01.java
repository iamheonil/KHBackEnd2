package gson;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/gson01")
public class GsonTest_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("GSON 테스트");
		
		// Gson 라이브러리 객체 생성
		Gson gson = new Gson();
		
		// toJson() - Java데이터 -> JSON Text 로 변환 (마샬링)
		
		// fromJson() - JSON Text -> Java 데이터로 변환 (언마샬링)
		
		// int 형 데이터
		System.out.println(gson.toJson(123));
		
		// String 형 데이터
		System.out.println(gson.toJson("apple"));
		
		// Long 형 데이터
		System.out.println(gson.toJson(new Long(20)));
		System.out.println(gson.toJson(20L));
		
		// int[] 형 데이터
		int[] arr = {1,2,3,4,5};
		System.out.println(gson.toJson(arr));
		
		System.out.println("================================");
		
		// int 형 데이터 언마샬링
		int n1 = gson.fromJson("123", int.class);
		System.out.println(n1);		
		
		// String 형 데이터 언마샬링
		String str = gson.fromJson("Apple", String.class);
		System.out.println(str);
		
		
	}
	
}