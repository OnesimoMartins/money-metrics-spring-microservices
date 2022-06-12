package ao.statservice.domain.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TimeFilter {
	
	@DateTimeFormat(iso = ISO.DATE)
	private final LocalDate since;

	@DateTimeFormat(iso = ISO.DATE)
	private final LocalDate until;
}
