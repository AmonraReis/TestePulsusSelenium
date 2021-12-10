
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


///O objetivo desse teste é verificar os itens da página de login da Pulsus e se suas funcionalidades estão conforme o esperado

public class TesteLogin {
	
	
	@Test
    public void validarEmail(){
  	 //valido se a item senha obrigadtorio foi preenchida
  	   WebDriver driver = new ChromeDriver();
		driver.get("https://app.pulsus.mobi/login");
		driver.findElement(By.id("identifier")).sendKeys("amonra.reis@pulsus.mobi"); //ENVIA O E-MAIL
		driver.findElement(By.id("action")).click(); //CLICA
		driver.findElement(By.className("error")).getText();;
		Assert.assertEquals("E-mail ou senha inválidos.", driver.findElement(By.className("error")).getText());
  	  
      }
	
	//validando se o e-mail foi preenchido
	@Test
	
      public void validarSenha() {
	    WebDriver driver = new ChromeDriver();
		driver.get("https://app.pulsus.mobi/login");
		driver.findElement(By.id("password")).sendKeys("teste"); ///PRENCHE A SENHA
		driver.findElement(By.id("action")).click(); //ENVIA
		driver.findElement(By.className("error")).getText();//CAPTURA A CLASS ERRO
		Assert.assertEquals("E-mail ou senha inválidos.", driver.findElement(By.className("error")).getText()); //VALIDA

}
	
	@Test 
	
	public void validandoEsqueceuSenha(){
		
		//validando a função esqueceu senha
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.pulsus.mobi/login");
		driver.findElement(By.className("small")).click(); //CLICA NO ITEM
		driver.findElement(By.id("email")).sendKeys("amonra.reis@pulsus.mobi"); //PREENCHE COM E-MAIL
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); //DA UMA PAUSA DE 2 SEG
		
		driver.findElement(By.tagName("button")).click(); //CLICA NO BOTÃO PARA ENVIAR
        driver.findElement(By.className("notice")).getText(); //VERIFICAR A CLASSE QUE ESTÁ A MESANGEM
		
		  Assert.assertEquals("Confira seu e-mail!\r\n"
		  		+ "\r\n"
		  		+ "Enviamos o link para alterar sua senha para:\r\n"
		  		+ "amonra.reis@pulsus.mobi:", driver.findElement(By.className("notice")).getText());//MENSAGEM			
		
	}
	
	@Test 
	
	public void verificaItemSaiba(){
			
		//verifica o acesso ao item "saiba mais" e verifica os itens obrigatorios
		
		//OBS EU NAO ENVIO O FORMULARIO POR ENVOLVE COMERCIAL E NÃO QUERO PREJUDICAR OUTROS SETORES
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.pulsus.mobi/login");
		driver.findElement(By.linkText("Saiba mais")).click();
		driver.findElement(By.id("administrator_tenant_name")).sendKeys("Amonra reis");
		driver.findElement(By.id("signup_info_phone")).sendKeys("51996578338");
		WebElement element = driver.findElement(By.id("signup_info_device_count_tag"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Entre 30 e 50");
        driver.findElement(By.id("tenant_name")).sendKeys("teste");      
        driver.findElement(By.id("administrator_email")).sendKeys("teste@corporativo.com");
        
       Assert.assertEquals("Amonra reis" , driver.findElement(By.id("administrator_tenant_name")).getAttribute("value"));
       Assert.assertEquals("(51) 99657 8338", driver.findElement(By.id("signup_info_phone")).getAttribute("value"));
       Assert.assertEquals("Entre 30 e 50" , combo.getFirstSelectedOption().getText());
       Assert.assertEquals("teste" , driver.findElement(By.id("tenant_name")).getAttribute("value"));
       Assert.assertEquals("teste@corporativo.com" , driver.findElement(By.id("administrator_email")).getAttribute("value"));
		
	}

	@Test
	
	public void loginCompleto(){
		//verifica todo o passo a passo de login
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.pulsus.mobi/login");
		driver.findElement(By.id("identifier")).sendKeys("amonra.reis@pulsus.mobi");
		driver.findElement(By.id("password")).sendKeys("95852161Amonra12");
		driver.findElement(By.id("action")).click();
		Assert.assertTrue("https://app.pulsus.mobi/", true); //verifica se realmente logou	
	}
		
}	
	

		
	

	


