#include <msp430.h>
/**
 * main.c
 */

int ADCValue;
int ADCValueAdjusted;
void gpioInit();     // Setup the GPIO Pins for controlling the LEDS through PWM (no input arguments)
void timerInit();    // Setup Timer to control the LEDS (no input arguments)
void adcInit();      // Setup ADC to do single, on demand samples (no input arguments)
int readADCSingle(); // Single Read ADC, no input arguments, returns current ADC reading
int main(void)
{
    WDTCTL = WDTPW | WDTHOLD; // stop watchdog timer
    gpioInit();
    adcInit();
    timerInit();

    while (1)
    {
        ADCValue = readADCSingle();
        ADCValueAdjusted = ADCValue / 40.96 setLEDBrightness();
        TB3CCR0 = 67000-1; // PWM Period
        TB3CCTL1 = OUTMOD_7; // CCR1 reset/set
        TB3CCR1 = 2500; // CCR1 PWM duty cycle
        TB3CTL = TBSSEL__SMCLK | MC__UP | TBCLR; // SMCLK, up mode, clear TBR


    }
    return 0;
}
/**
 * GPIO INIT
 * Initialize all GPIO Pins. Current Pin configuration:
 * Pin 1.0: OUTPUT, GPIO
 * Pin 1.1: INPUT, ADC Channel 1
 */
void gpioInit()
{
     // Configure GPIO Pin
    P6DIR |= BIT0; // P6.0 output
    P6SEL0 |= BIT0;
    P6SEL1 &= ~BIT0; // P6.0 options select

    
    // Configure ADC Pin
    P1DIR &= ~BIT1; // P1.1 Input
    P6SEL0 |= BIT1;
    P6SEL1 &= ~BIT1; // P6.0 options select

}
/**
 * Timer INIT
 * Initialize the Timer Peripheral to control a GPIO Pin with PWM in up mode
 * Timer Mode: Up Mode
 */
void timerInit()
{
    // Configure Timer Module to Up Mode
    // Configure CCR Registers
    TB0CTL |= TBCLR | TBSSEL__SMCLK | MC__UP; //clear timer and dividers | clk source = submain | up mode
    TB0CCR0 = 1000;
    TB0CCR1 = 500;
}
/**
 * ADC INIT
 * Initialize the ADC Peripheral to read Single measurements on demand.
 * ADC MODE: Single Sample, Single Conversion
 */
void adcInit()
{

    ADCCTL0 |= ADCSHT_8 | ADCON;       // ADC ON,temperature sample period>30us
    ADCCTL1 |= ADCSHP | ADCCONSEQ_2;   //|ADCSSEL_2; // s/w trig, singlech/conv, MODOSC(5MHz)
    ADCCTL2 &= ~ADCRES;                // clear ADCRES in ADCCTL
    ADCCTL2 |= ADCRES_2 | ADCSR;       // 12-bit conversion results
    ADCMCTL0 |= ADCSREF_1 | ADCINCH_1; // ADC input ch A12 => temp sense
    // ADCIE |=ADCIE0;
}
/**
 * Read Single ADC Sample from Channel 0 of the ADC12 Peripheral
 * Returns an ADC Sample without interrupts.
 */
int readADCSingle()
{
    ADCCTL0 |= ADCENC | ADCSC;
    while (!(ADCIFG & ADCIFG0)); // Wait for sample to be sampled and converted
    return ADCMEMO;
}
/**
 * Set LED Brightness on the LED configured from gpioInit. This modifies the
 * CCR register based on the input.
 * int DutyCycle: Value between 0-100
 */
void setLEDBrightness(int DutyCycle)
{
    TB0CCR1 = (int)DutyCycle;
}
