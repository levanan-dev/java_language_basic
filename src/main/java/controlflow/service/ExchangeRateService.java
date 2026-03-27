package controlflow.service;

public interface ExchangeRateService {
  Double convertToUsd(Double amount, String fromCurrency);
}
