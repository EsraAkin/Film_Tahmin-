import java.util.*;

public class filmff {
    public static void main(String[] args) {
        tahminHakki();
    }

    public static void tahminHakki() {
        ArrayList<String> filmler = new ArrayList<>(Arrays.asList("JOKER", "INCEPTION", "PIYANIST", "GREENMILE", "LEON", "GODFATHER", "JURASSICPARK", "TITANIC"));
        Scanner input = new Scanner(System.in);

        System.out.println("0 ile " + (filmler.size() - 1) + " arasında bir numara seçiniz. ");
        int kullaniciIndex = input.nextInt();
        String secilenfilm = filmler.get(kullaniciIndex);
        System.out.println(secilenfilm);
        System.out.println("Seçtiğiniz Filmin harf sayısı: " + secilenfilm.length());

        int tahminHakki = 2 * secilenfilm.length();        // Tahmin hakkı, harf sayısının 2 katı
        System.out.println("Filmi doğru tahmin etmek için " + tahminHakki + " hakkınız vardır.");

        String[] bos = new String[secilenfilm.length()];   // Tahmin edilen harfler için boş bir dizi
        Arrays.fill(bos, "_");                          // İlk başta boşluğu (_) göster.

        char[] harfler = secilenfilm.toCharArray();        // Filmin harflerini tutan dizi

        int kalanHakSayisi = tahminHakki;                 // Kalan hakları kontrol etmek için
        int dogruTahminSayisi = 0;
        int yanlisTahminSayisi = 0;
        boolean kazandiMi = false;

        while (kalanHakSayisi > 0) {
            // Tahmin edilen filmin mevcut durumunu güncelle.
            String tahminDurumu = "";
            for (String w : bos) {
                tahminDurumu += w + " ";  // Her harfi boşluk ile birleştiriyoruz
            }

            System.out.println("Tahmin edilen film: " + tahminDurumu.trim());  // O anki tahmin durumu
            System.out.println("Bir harf tahmin ediniz:");
            char kullaniciHarf = input.next().charAt(0);  // Kullanıcıdan harf alıyoruz

            boolean harfVarmi = false;  // Harf bulunup bulunmadığını kontrol etmek için
            for (int i = 0; i < harfler.length; i++) {
                if (harfler[i] == kullaniciHarf) {   // Harfi kontrol ediyoruz
                    bos[i] = String.valueOf(kullaniciHarf);  // Eğer doğru tahminse, diziye ekliyoruz
                    harfVarmi = true;
                }
            }

            if (harfVarmi) {
                System.out.println("Doğru tahmin!");
                dogruTahminSayisi++;  // Toplam doğru tahmin sayısını bir artırıyoruz
            } else {
                System.out.println("Yanlış tahmin.");
                yanlisTahminSayisi++;  // Yanlış tahmin sayısını artırıyoruz
            }

            kalanHakSayisi--;  // Hangi tahmin olursa olsun, hak bir azalır
            System.out.println("Doğru Tahmin Sayısı: " + dogruTahminSayisi);
            System.out.println("Yanlış Tahmin Sayısı: " + yanlisTahminSayisi);

            // Oyuncu filmi doğru tahmin etti mi?
            String tahminStringi = "";
            for (String harf : bos) {
                tahminStringi += harf;  // Tahmin edilen durumu birleştiriyoruz
            }

            if (tahminStringi.equals(secilenfilm)) {
                kazandiMi = true;
                break;  // Tüm harfleri doğru bildiyse döngüyü bitiriyoruz
            }

            System.out.println("Kalan hak sayısı: " + kalanHakSayisi);
        }

        // Oyunun sonucu
        if (kazandiMi) {
            System.out.println("Tebrikler, filmi doğru tahmin ettiniz: " + secilenfilm);
        } else {
            System.out.println("Maalesef hakkınız bitti. Doğru film: " + secilenfilm);
        }
    }
}

