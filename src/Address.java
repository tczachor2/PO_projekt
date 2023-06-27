public class Address {
    private String city, street, country;
    private int zipCode, num;

    public Address(String city, String street, String country, int zipCode, int num) {
        this.city = city;
        this.street = street;
        this.country = country;
        this.zipCode = zipCode;
        this.num = num;
    }

    public Address(String adress) {
        String[] arr = adress.split(" ");
        System.out.println(arr.length);
        if(arr.length >= 4) {
            this.city = arr[1];
            this.street = arr[3];
            this.country = arr[0];
            this.zipCode = Integer.valueOf(arr[2]);
            this.num = Integer.valueOf(arr[4]);
        }else{
            this.city = "empty";
            this.street = "empty";;
            this.country = "empty";;
            this.zipCode = 0;
            this.num = 0;
        }
    }

    @Override
    public String toString() {
        return country + " " + city + " " + zipCode + " " + street + " " + num;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
