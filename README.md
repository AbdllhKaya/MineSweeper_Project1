Oyun Kuralları:

Oyun metin tabanlıdır.
Proje, çift boyutlu diziler kullanılarak yapılmıştır.
Methodlar,  MineSweeper sınıfı içerisinde tasarlanmıştır. 
Matris boyutunu yani satır ve sütun sayısını kullanıcı belirlemiştir. Minimum 2x2 boyutunda matris grişine izin verilmiş, 2x2 den küçük değer girişlerinde kullanıcıya uyarı verilmiş ve tekrar satır, sütun girmesi istenmiştir.
Diziye ait eleman sayısının çeyreği (elemanSayisi / 4) kadar rastgele mayın yerleştirilmiştir. Mayın sayısı, eleman sayısı/4'ten az ya da çok değildir. Örneğin dizi 4x3 boyutunda ise eleman sayısı (satırSayısı * sütunSayısı) formülü ile hesaplanmalı ve boyutu 12 olacaktır. Bu durumda mayın sayısı 12 / 4 = 3 adet olmalıdır. 3'ten az ya da çok olmamalıdır.
Mayınlar "*" sembolü ile gösterilmiştir. 
Kullanıcı matris üzerinden bir nokta seçmeli, nokta seçimi için satır ve sütun değerlerini girmesi istenilmiştir.
Seçilen noktanın dizinin sınırları içerisinde olup olmadığı kontrol edilmiş ve koşul sağlanmazsa konsolda uyarı metni yazdırılıp kullanıcıdan tekrar yeni koordinat istenilmiştir.
Daha önce girilmiş bir koordinat girildiğinde kullanıcıya "bu koordinat daha önce seçildi, başka bir koordinat girin" şeklinde uyarı gösterilmiş ve yeni giriş yapması sağlanmıştır.
Kullanıcının girdiği noktada mayın var ise oyunu kullanıcı oyunu kaybetmektedir ve buna uygun şekilde konsolda mesaj gösterilmiştir.
Kullanıcının girdiği noktada mayın yok ise noktanın etrafındaki tüm komşu konumlara bakılmış (sağı, solu, yukarısı, aşağısı, sol üst çapraz, sağ üst çapraz, sağ alt çapraz, sol alt çapraz) ve bu komşu noktalardaki mayınların sayısının toplamı kullanıcının girmiş olduğu koordinata yazılmıştır. Noktaya değen herhangi bir mayın yok ise "0" değeri yazılmıştır. Farklı değer ve sembol kullanılmamıştır.
Kullanıcı hiç bir mayına basmadan tüm noktaları açarsa oyunu kazanma senaryosu hazırlanmıştır. Bu durumda da uygun mesaj konsolda gösterilmiştir.

Kaybetme Senaryosu:

Mayınların Konumu
* - - 
- - * 
- - - 
===========================
Mayın Tarlası Oyuna Hoşgeldiniz !
- - - 
- - - 
- - - 
Satır Giriniz : 0
Sütun Giriniz : 1
===========================
- 2 - 
- - - 
- - - 
Satır Giriniz : 2
Sütun Giriniz : 0
===========================
- 2 - 
- - - 
0 - - 
Satır Giriniz : 0
Sütun Giriniz : 2
===========================
- 2 1 
- - - 
0 - - 
Satır Giriniz : 1
Sütun Giriniz : 0
===========================
- 2 1 
1 - - 
0 - - 
Satır Giriniz : 2
Sütun Giriniz : 1
===========================
- 2 1 
1 - - 
0 1 - 
Satır Giriniz : 2
Sütun Giriniz : 2
===========================
- 2 1 
1 - - 
0 1 1 
Satır Giriniz : 1
Sütun Giriniz : 2
Game Over!!
===========================

Kazanma Senaryosu

Mayınların Konumu
- - - 
- * - 
- * - 
===========================
Mayın Tarlası Oyuna Hoşgeldiniz !
- - - 
- - - 
- - - 
Satır Giriniz : 0
Sütun Giriniz : 0
===========================
1 - - 
- - - 
- - - 
Satır Giriniz : 0
Sütun Giriniz : 1
===========================
1 1 - 
- - - 
- - - 
Satır Giriniz : 0
Sütun Giriniz : 2
===========================
1 1 1 
- - - 
- - - 
Satır Giriniz : 1
Sütun Giriniz : 0
===========================
1 1 1 
2 - - 
- - - 
Satır Giriniz : 2
Sütun Giriniz : 0
===========================
1 1 1 
2 - - 
2 - - 
Satır Giriniz : 1
Sütun Giriniz : 2
===========================
1 1 1 
2 - 2 
2 - - 
Satır Giriniz : 2
Sütun Giriniz : 2
Oyunu Kazandınız !
1 1 1 
2 - 2 
2 - 2 
===========================
