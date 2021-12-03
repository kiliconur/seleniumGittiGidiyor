# seleniumhomework

-Test Senaryoları-

mainPageTest - "https://www.gittigidiyor.com/" sayfası açılır ve açılan sayfanın doğruluğu kontrol edilir.

loginPageTest - Fare imleci giriş yap butonun üzerine gelir ve sonrasında görünür olan menüden giriş yap butonuna tıklanır, login bilgileri girilir ve login olunur. 

Hesabım panelinin gözüküp gözükmediği kontrol edilir, gözükmediği takdirde giriş yapılmadığı anlaşılır.

searchProd - Arama bölümüne kalem yazılıp arama yapılır. Yeni açılan sayfada "kalem" ve "ürün bulundu" textlerinin mevcut olup olmadığı kontrol edilir. Mevcutsa test başarılıdır.

addFavourites - Ürünlerin sağ üstünde bulunan kalp şeklinde 2 çeşit element mevcuttur. Tıklandığında mavi renkli olur ve ürün favoriye alınır, tıklanmadığında beyaz renkli olarak
gözükür. Bunların arasından favorilere eklenmemişler bulunarak bunların arasından 4 tane random ürün favoriye eklenir(oluşturulan random sayılar birbirlerinden farklı olacak şekilde)
3. sırada favoriye eklenen elementin ürün isim bilgisi (elementlerin id'lerinin karşılaştırılmasıyla bulunarak) sonradan kullanılmak üzere kaydedilir. Favorilere alınan ürün
sayısından, adım başındaki favorilerdeki ürün sayısı çıkarılarak favorilere yeni eklenen ürün sayısı bulunur. 4'ten farklı olduğunda test adımı başarısızdır.

returnToMainPage - Navigate back ile anasayfaya geri dönülür. Kontrolü sağlanır.

addProdToCart - Arama bölümüne çanta yazılıp arama yapılır. Yeni açılan sayfada "çanta" ve "ürün bulundu" textlerinin mevcut olup olmadığı kontrol edilir. Ardından 
7.sıradaki ürüne tıklanır ve sepete ekleme işlemi yapılır. Sepetteki mevcut eşya sayısı ile ekleme yapılmadan önceki eşya sayısı karşılaştırılır, farkın 1 arttığı durumda test başarılıdır.

goToCart - Sağ üstte bulunan sepetim butonuna tıklanır. Açılan sayfanın "https://www.gittigidiyor.com/sepetim" olup olmadığı kontrol edilir.

increaseitem - Sepette ilk sırada bulunan eşyanın, sepetteki sayısı kaydedilir. Bu sayı 1 arttırılmaya çalışılır. Ürün arttırılmıyorsa o eşyanın sepette maximum sayıda mevcut
olduğu mesajı verilir. Ürünün arttırıldığı durumda ise, arttırılmadığı durumdaki sayısı ile karşılaştırılıp farkın 1 arttığı durumda test başarılıdır.

goToPayment - Alışverişi tamamla butonuna tıklanır ve açılan sayfada sipariş özeti bölümünün olup olmadığı kontrol edilir. Olduğu durumda test başarılıdır.

saveAddress - Adres kaydet butonuna tıklanır ve hata mesajlarının görünür olup olmadığı kontrol edilir. Görünür olduğu durumda test başarılıdırç

editCart - Alışveriş özeti bölümündeki sepeti düzenle butonuna tıklanır ve "https://www.gittigidiyor.com/sepetim" adresine gidilip gidilmediği kontrol edilir.

addProductFromFav - Sepet ekranında, sonradan alacaklarım bölümündeki ilk ürün sepete eklenir. Sepetteki ürün çeşidi bilgisi alınır.Sepetteki ürün çeşidi artmışsa test başarılıdır.

seeAllFav - "https://www.gittigidiyor.com/hesabim/izlediklerim" adresine gidilir ve adresin kontrolü sağlanır.

deleteFavItem - İzlediklerim sayfasındaki ürünlerden, önceden kaydetmiş olduğumuz ürün ismine uygun olan ürün bulunur. Ürünler tablo halinde saklandığından tabloda bu ürünün
sol tarafında bulunan checkbox'a tıklanır. Ardından çöp kutusu simgesine tıklanarak ürünün silme işlemi yapılır. Önceden kaydedilmiş olan ürün ismi tekrardan aranır.
Bulunmadığı takdirde ürün silinmiştir ve test başarılıdır.

newTab - Sol üstte bulunan gittigidiyor logosu yeni sekmede açılır. Yeni sekmeye geçiş yapılır ve url'in "https://www.gittigidiyor.com/" olduğu kontrol edilir.

logOut - Fare imleci hesabıma getirilir ve sonrasında çıkış yap butonuna tıklanarak çıkış yapılır. Giriş yap butonunun mevcut olup olmadığı kontrol edilir, mevcut olduğu durumda
çıkış işleminin başarılı yapıldığı anlaşılır.

closeTab - Mevcut sekme kapatılır, sekme sayısı ile kapatılmadan öncesi sekme sayısı karşılaştırılır. 1 azaldığı durumda test başarılıdır.






