package com.tek.interview.question;


public class Item {
	//This will give the flexibility to change the percentage if needed
	//and to add more values if needed in future
    enum Type{
        Imported("imported",0.15),Exported("exported",0.10);
        String name;

        Double percentage;

        Type(String name,Double percentage){
            this.name = name;
            this.percentage = percentage;
        }

        String getMatchKey(){
            return name;
        }

        Double getPercentage(){
            return percentage;
        }
    }

    private String description;
    private float price;

    public Item(String description, float price) {
        super();
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public Type getType(){
        return getDescription().contains(Type.Imported.getMatchKey()) ? Type.Imported :Type.Exported;

    }

    public Double getTax() {
        return Calculator.rounding(getPrice() * getType().getPercentage());
    }


    public Double getTotalPrice() {
    	return Calculator.rounding(getPrice() + getTax());
    }


}
