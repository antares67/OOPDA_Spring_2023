#include <msp430.h>
void gpioInit();  
void timerInit();  
void adcInit();  
int readADCSingle(); 
void setLEDBrightness(int DutyCycle); 
                    

int main(void)

{
  WDTCTL = WDTPW | WDTHOLD;  // stop watchdog timer

  gpioInit();  // start gpio
  adcInit();  // start adc
  timerInit();  // start timer


  PM5CTL0 &= ~LOCKLPM5;

  while (1) {
    int ADC_Reading = readADCSingle();

    int DutyCycle = (int)ADC_Reading / 40.96;

    setLEDBrightness(DutyCycle);
  }

  return 0;
}


void gpioInit() {
  // Configure LED Pin

  P6DIR |= BIT0;  
  P6SEL0 |= BIT0;
  P6SEL1 &= ~BIT0;  
  P1SEL0 |= BIT1;  
  P1SEL1 |= BIT1; 
}


void timerInit() {

  TB0CCR0 = 1000 - 1;  // PWM 
  TB0CCTL1 = OUTMOD_7;  // reset/set
  TB0CCR1 = 750;  // duty cycle
  TB0CTL = TBSSEL__SMCLK | MC__UP | TBCLR;  // SMCLK, up mode, clear TBR
}

void adcInit() {

  ADCCTL0 |= ADCSHT_2 | ADCON;  
  ADCCTL1 |= ADCSHP;  
  ADCCTL2 &= ~ADCRES;  
  ADCCTL2 |= ADCRES_2;  
  ADCMCTL0 |= ADCINCH_1;  
}

int readADCSingle() {
  ADCCTL0 |= ADCENC | ADCSC;  // Sampling and conversion start
  while (!(ADCIFG & ADCIFG0));  // Wait for sample to be sampled and converted
  return ADCMEM0;
}

void setLEDBrightness(int DutyCycle){
     TB0CCR1 = (int)9.9 * DutyCycle; 
}