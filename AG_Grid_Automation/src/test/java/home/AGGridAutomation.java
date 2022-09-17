package home;
import java.util.ArrayList;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AGGridAutomation {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://ag-grid.com/example/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		String props = 
		"window.findReactComponent = function(el) {\n"
		+ "  for (const key in el) { console.log(key);\n"
		+ "    if (key.startsWith('__reactEventHandlers$')) {\n"
		+ "      const fiberNode = el[key];\n"
		+ "      return fiberNode;\n"
		+ "    }\n"
		+ "  }\n"
		+ "  return null;\n"
		+ "};"
		+ ""
		+ "var grid = document.getElementById(\"myGrid\");"
		+ "var reactGrid = findReactComponent(grid);"
		+ "var props = reactGrid.children.props;";
		
		String columnCount = props + " return props.gridOptions.columnDefs.length;";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Object result = js.executeScript(columnCount);
		System.out.println("No of primary columns in header = " + result);
		
		
		ArrayList<String> data = 
                new ArrayList<String>();
		String columnValues = props + "var columnData = props.gridOptions.columnDefs;" +
				"var headers = []; "
				+ "columnData.forEach(function(obj) { headers.push(obj.headerName); "
				+ "if( obj.children !=null){"
				+ " obj.children.forEach(function(obj) "
				+ "{ headers.push(obj.headerName); });}});"
				+ "return headers;";
	    data =  (ArrayList<String>) js.executeScript(columnValues);

		System.out.println("Header columns: ");
		for(String ele: data)
		{
			System.out.println(ele);
		}

		driver.quit();

	}

}
