package controlflow.model;

// Input
public class RawTransaction {
  private String id;
  private Double amount;
  private String currency; // "USD", "VND", "EUR"...
  private String type; // "DEPOSIT", "WITHDRAWAL", "TRANSFER"
  private String status; // "PENDING", "COMPLETED", "FAILED"
}
