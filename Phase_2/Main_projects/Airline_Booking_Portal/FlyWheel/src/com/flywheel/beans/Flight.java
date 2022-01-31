package com.flywheel.beans;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name ="flight")
public class Flight {
	   @Id
	   @GeneratedValue(strategy =  GenerationType.AUTO)
	   @Column(name = "flight_num")
	    private int flightnum;
	   @Column(name ="flight_name")
		private String flightname;
		@Column(name ="source")
		private String source;
		@Column(name ="destination")
		private String destin;
		@Column(name ="date")
		private String date;
		@Column(name ="price")
		private float  price;
		@Column(name ="capacity")
		private int  capacity;
		
		
		public Flight () { 
			
		}


		public Flight(String flightname, String source, String destin, String date, float price, int capacity) {
			super();
			this.flightname = flightname;
			this.source = source;
			this.destin = destin;
			this.date = date;
			this.price = price;
			this.capacity = capacity;
		}


		public String getFlightname() {
			return flightname;
		}


		public void setFlightname(String flightname) {
			this.flightname = flightname;
		}


		public String getSource() {
			return source;
		}


		public void setSource(String source) {
			this.source = source;
		}


		public String getDestin() {
			return destin;
		}


		public void setDestin(String destin) {
			this.destin = destin;
		}


		public String getDate() {
			return date;
		}


		public void setDate(String date) {
			this.date = date;
		}


		public float getPrice() {
			return price;
		}


		public void setPrice(float price) {
			this.price = price;
		}


		public int getCapacity() {
			return capacity;
		}


		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}


		@Override
		public String toString() {
			return "Flight [flightname=" + flightname + ", source=" + source + ", destin=" + destin + ", date=" + date
					+ ", price=" + price + ", capacity=" + capacity + "]";
		}


		
		
		
		
}
