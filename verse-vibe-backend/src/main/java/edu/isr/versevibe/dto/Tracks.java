package edu.isr.versevibe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

import java.util.ArrayList;

@Setter
public class Tracks{
    @JsonProperty("href")
    public String getHref() { 
		 return this.href; }

    String href;
    @JsonProperty("items") 
    public ArrayList<Item> getItems() {
		 return this.items; }

    ArrayList<Item> items;

    @Override
    public String toString() {
        return "Tracks{" +
                "href='" + href + '\'' +
                ", items=" + items +
                ", limit=" + limit +
                ", next='" + next + '\'' +
                ", offset=" + offset +
                ", previous=" + previous +
                ", total=" + total +
                '}';
    }

    @JsonProperty("limit")
    public int getLimit() { 
		 return this.limit; }

    int limit;
    @JsonProperty("next") 
    public String getNext() { 
		 return this.next; }

    String next;
    @JsonProperty("offset") 
    public int getOffset() { 
		 return this.offset; }

    int offset;
    @JsonProperty("previous") 
    public Object getPrevious() { 
		 return this.previous; }

    Object previous;
    @JsonProperty("total") 
    public int getTotal() { 
		 return this.total; }

    int total;
}
