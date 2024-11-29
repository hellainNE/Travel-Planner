public class TravelPlan {
  private String name;
  private String date;
  private String destination;
  private double budget;
  private String itinerary; // New feature: Itinerary
  private long countdown; // New feature: Travel countdown in milliseconds

  public TravelPlan(String name, String date, String destination, double budget, String itinerary) {
      this.name = name;
      this.date = date;
      this.destination = destination;
      this.budget = budget;
      this.itinerary = itinerary;
      setCountdown(date); // Set countdown from the travel date
  }

  // Getters and setters
  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public String getDate() {
      return date;
  }

  public void setDate(String date) {
      this.date = date;
      setCountdown(date); // Update countdown if date is changed
  }

  public String getDestination() {
      return destination;
  }

  public void setDestination(String destination) {
      this.destination = destination;
  }

  public double getBudget() {
      return budget;
  }

  public void setBudget(double budget) {
      this.budget = budget;
  }

  public String getItinerary() {
      return itinerary;
  }

  public void setItinerary(String itinerary) {
      this.itinerary = itinerary;
  }

  public long getCountdown() {
      return countdown;
  }

  private void setCountdown(String date) {
      // Convert date to a long value (milliseconds) and calculate countdown
      try {
          java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
          java.util.Date travelDate = sdf.parse(date);
          this.countdown = travelDate.getTime() - System.currentTimeMillis();
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
}
