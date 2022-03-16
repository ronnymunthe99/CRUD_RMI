/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author Ronny
 */
import java.util.*;
public class MapTest {
    public static void main(String[] args){
        //kunci-> integer, nilai-> string
        Map<Integer,String> map = new HashMap<Integer,String>();
	//menempatkan elemen kunci dan nilai
	map.put(1, "satu");
	map.put(2, "dua");
	//mengambil elemen pertama	
	System.out.println(map.get(1));
	//mengambil keseluruhan kunci sebagai objek collection Set	
	Set<Integer>key = map.keySet();
        //bagaimana iterasi untuk mengambil keseluruhan
        //nilai dari kunci ? tulis pada laporan anda!
        //petunjuk : gunakan iterasi seperti program ArrayListTest
        
        //untuk memanggil keseluruhan key
        for(Integer i : key) {
            System.out.println(i);
           }
	}
}

