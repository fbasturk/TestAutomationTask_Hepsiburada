# Test Automation Task

Bu projede Hepsiburada tarafından verilen task oluşturulmuş olup senaryoların Page Object Model kullanılarak koşulması sağlanmıştır. Test projesinin başlatılması için `src/test/java/bsturk/tests/BaseTest.java` dosyasını JUnit ile çalıştırılmalıdır.

## Proje Özellikleri
* Webdriver ları projede eklenmiştir. Versiyon uyuşmazlığında webdriverlar aynı isim ile src/test/resources/ altında güncellenmelidir.
* Web testi sırasında gerekli olan parametreler(Browser, Kullanıcı bilgileri) `BaseTest.java` altında başlatılacak Test içersinde parametre olarak verilmelidir.

        TestParameter testParameter = new TestParameter();
        testParameter.setBrowser(CreateDriverUtil.WebDriverType.CHROME);
        testParameter.setEmail("furkan.testautomation@gmail.com");
        testParameter.setPassword("12345678f");
        testParameter.setProductCount(3);
        
* Projenin log kaydı tutulmaktadır. Log kaydı error, info ve benzeri başlıklar için ayrı ayrı tutulmaktadır. Log kayıtları `Logs/` altında zamana göre tutulmaktadır.
* Test sırasında hata ile karşılaşıldığı zamanda ekran görüntüsü kaydetmektedir. Ekran görüntüleri `ScreenshotFile/` altında zamana ve hata ile karşılaşılan senaryo adına göre tutulmaktadır.

## Hepsiburada Task İsterleri
Login olup 3 adet ürünü gezdikten sonra sepet sayfasını açıp “Son Gezdikleriniz” önerilerinde
gezdiğiniz 3 ürünün de bulunduğunu gösteren bir senaryo için test otomasyonu yazınız.

a) Testi herhangi bir dil ve test framework’ü ile yazabilirsiniz. (Çalışır durumda olması önemli.)
*Projenin ihtiyaç duyacağı external paketleri eklemeyi unutmayın.

b) Test içerisinde sayfa geçişlerinde doğru sayfada olunup olunmadığını kontrol ediniz.

c) Test steplerinden biri hata aldığında screenshot’ını alıp kaydediniz.

d) Testi chrome ve firefox browserların çalışacak şekilde ayarlayınız ve browser ın parametrik
geçilebilmesini sağlayınız. (Bonus)

## Test Log Çıktısı

     1- Hepisburada's web test scenario begins.
     2- Browser Name: CHROME is getting ready to run.
     3- Browser Name: CHROME: Hepsiburada tests started.
     4- WebDriver created for Hepsiburada Tests

     5- Starting test scenarios in Hepsiburada Tests
        5.1- HomePage test scenario in Hepsiburada Tests
          HomePage test created for Hepsiburada Tests
             1. Step: Visiting 'Homepage'
             2. Step: Checking 'Homepage' visit
               ---> Current Window State       : interactive
               ---> Current Window State       : complete
             3. Step: Clicking the 'Login' button
          HomePage test completed for Hepsiburada Tests

        5.2- Login Operations test scenario in Hepsiburada Tests
          Login Operations test created for Hepsiburada Tests
             1. Step: Checking 'Login Page' visit
               ---> Current Window State       : complete
             2. Step: Clicking the 'Login' radio button
             3. Step: Email address is writing to email area
           4. Step: Password is writing to password area
             5. Step: Clicking the 'Login' button
        Login Operations test completed for Hepsiburada Tests

        5.3- Product Review test scenario in Hepsiburada Tests
          Product Review test created for Hepsiburada Tests
             1. Step: Checking 'Homepage' visit
               ---> Current Window State       : interactive
               ---> Current Window State       : complete
             2. Step: Checking Login
             3. Step: Checking 'Homepage' visit
               ---> Current Window State       : complete
             4. Step: The given item is selecting
             5. Step: Checking 'Product Page' visit
               ---> Current Window State       : loading
             ---> Current Window State       : complete
           6. Step: Getting product information
             7. Step: Clicking the 'HomePage' button
           8. Step: Checking 'Homepage' visit
             ---> Current Window State       : loading
             ---> Current Window State       : complete
             9. Step: The given item is selecting
           10. Step: Checking 'Product Page' visit
             ---> Current Window State       : loading
             ---> Current Window State       : interactive
             ---> Current Window State       : complete
           11. Step: Getting product information
           12. Step: Clicking the 'HomePage' button
           13. Step: Checking 'Homepage' visit
             ---> Current Window State       : loading
             ---> Current Window State       : complete
           14. Step: The given item is selecting
           15. Step: Checking 'Product Page' visit
             ---> Current Window State       : loading
               ---> Current Window State       : complete
           16. Step: Getting product information
           17. Step: Clicking the 'HomePage' button
        Product Review test completed for Hepsiburada Tests

        5.4- Check Product In My Cart test scenario in Hepsiburada Tests
        Check Product In My Cart test created for Hepsiburada Tests
           1. Step: Checking 'Homepage' visit
             ---> Current Window State       : loading
             ---> Current Window State       : complete
           2. Step: Clicking the 'MyCart' button
           3. Step: Checking 'My Cart Page' visit
             ---> Current Window State       : interactive
             ---> Current Window State       : complete
             4. Step: Scrolling down to product area
           5. Step: Checking is there a result for the product review
        Check Product In My Cart test completed for Hepsiburada Tests

     6- Test Complete Time:38483, Browser Name: CHROME is closed





