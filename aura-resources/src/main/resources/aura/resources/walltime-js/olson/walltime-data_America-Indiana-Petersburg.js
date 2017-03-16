(function() {
    window.WallTime || (window.WallTime = {});
    window.WallTime.data = {
        rules: {"US":[{"name":"US","_from":"1918","_to":"1919","type":"-","in":"Mar","on":"lastSun","at":"2:00","_save":"1:00","letter":"D"},{"name":"US","_from":"1918","_to":"1919","type":"-","in":"Oct","on":"lastSun","at":"2:00","_save":"0","letter":"S"},{"name":"US","_from":"1942","_to":"only","type":"-","in":"Feb","on":"9","at":"2:00","_save":"1:00","letter":"W"},{"name":"US","_from":"1945","_to":"only","type":"-","in":"Aug","on":"14","at":"23:00u","_save":"1:00","letter":"P"},{"name":"US","_from":"1945","_to":"only","type":"-","in":"Sep","on":"lastSun","at":"2:00","_save":"0","letter":"S"},{"name":"US","_from":"1967","_to":"2006","type":"-","in":"Oct","on":"lastSun","at":"2:00","_save":"0","letter":"S"},{"name":"US","_from":"1967","_to":"1973","type":"-","in":"Apr","on":"lastSun","at":"2:00","_save":"1:00","letter":"D"},{"name":"US","_from":"1974","_to":"only","type":"-","in":"Jan","on":"6","at":"2:00","_save":"1:00","letter":"D"},{"name":"US","_from":"1975","_to":"only","type":"-","in":"Feb","on":"23","at":"2:00","_save":"1:00","letter":"D"},{"name":"US","_from":"1976","_to":"1986","type":"-","in":"Apr","on":"lastSun","at":"2:00","_save":"1:00","letter":"D"},{"name":"US","_from":"1987","_to":"2006","type":"-","in":"Apr","on":"Sun>=1","at":"2:00","_save":"1:00","letter":"D"},{"name":"US","_from":"2007","_to":"max","type":"-","in":"Mar","on":"Sun>=8","at":"2:00","_save":"1:00","letter":"D"},{"name":"US","_from":"2007","_to":"max","type":"-","in":"Nov","on":"Sun>=1","at":"2:00","_save":"0","letter":"S"}],"Pike":[{"name":"Pike","_from":"1955","_to":"only","type":"-","in":"May","on":"1","at":"0:00","_save":"1:00","letter":"D"},{"name":"Pike","_from":"1955","_to":"1960","type":"-","in":"Sep","on":"lastSun","at":"2:00","_save":"0","letter":"S"},{"name":"Pike","_from":"1956","_to":"1964","type":"-","in":"Apr","on":"lastSun","at":"2:00","_save":"1:00","letter":"D"},{"name":"Pike","_from":"1961","_to":"1964","type":"-","in":"Oct","on":"lastSun","at":"2:00","_save":"0","letter":"S"}]},
        zones: {"America/Indiana/Petersburg":[{"name":"America/Indiana/Petersburg","_offset":"-5:49:07","_rule":"-","format":"LMT","_until":"1883 Nov 18 12:10:53"},{"name":"America/Indiana/Petersburg","_offset":"-6:00","_rule":"US","format":"C%sT","_until":"1955"},{"name":"America/Indiana/Petersburg","_offset":"-6:00","_rule":"Pike","format":"C%sT","_until":"1965 Apr 25 2:00"},{"name":"America/Indiana/Petersburg","_offset":"-5:00","_rule":"-","format":"EST","_until":"1966 Oct 30 2:00"},{"name":"America/Indiana/Petersburg","_offset":"-6:00","_rule":"US","format":"C%sT","_until":"1977 Oct 30 2:00"},{"name":"America/Indiana/Petersburg","_offset":"-5:00","_rule":"-","format":"EST","_until":"2006 Apr 2 2:00"},{"name":"America/Indiana/Petersburg","_offset":"-6:00","_rule":"US","format":"C%sT","_until":"2007 Nov 4 2:00"},{"name":"America/Indiana/Petersburg","_offset":"-5:00","_rule":"US","format":"E%sT","_until":""}]}
    };
    window.WallTime.autoinit = true;
}).call(this);