package com.scuffed.jsonimporter.scheduled;

import java.lang.System.Logger.Level;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import com.scuffed.jsonimporter.model.Invoice;
import com.scuffed.jsonimporter.model.InvoiceStatus;
import com.scuffed.jsonimporter.repository.InvoiceRepository;
import com.scuffed.jsonimporter.repository.InvoiceStatusRepository;

@Configuration
@EnableScheduling
public class StatusChanger {
	
	private final InvoiceRepository invoiceRepository;
	private final InvoiceStatusRepository statusRepository;
	
	@Autowired
	public StatusChanger(InvoiceRepository invoiceRepository, InvoiceStatusRepository statusRepository) {
		this.invoiceRepository = invoiceRepository;
		this.statusRepository = statusRepository;
	}
	
	@Scheduled(fixedRate = 10, initialDelay = 10, timeUnit = TimeUnit.SECONDS)
	public void runStatusChanger() {
		List<Invoice> invoices = invoiceRepository.findAll();
		List<InvoiceStatus> statuses = this.statusRepository.findAll();
		invoices.forEach(e -> e.setStatus(statuses.get(ThreadLocalRandom.current().nextInt(statuses.size()))));
		if(!invoices.isEmpty()) {
			invoiceRepository.saveAll(invoices);
		}
		//TODO: Durch Logger ersetzen.
		System.out.printf("[%s-%s-%s %s:%s:%s] %s [%s]: %s",
						  LocalDateTime.now().getYear(),
						  LocalDateTime.now().getMonthValue(),
						  LocalDateTime.now().getDayOfMonth(),
						  LocalDateTime.now().getHour(),
						  LocalDateTime.now().getMinute(),
						  LocalDateTime.now().getSecond(),
						  "Abrechnungsstatus",
						  Level.INFO.getName(),
						  "Abrechnungsstatus zufällig neu zugewiesen.");
	}
}