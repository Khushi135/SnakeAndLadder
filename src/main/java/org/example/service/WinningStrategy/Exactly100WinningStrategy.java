package org.example.service.WinningStrategy;

public class Exactly100WinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(int position) {
        return position == 100;
    }
}
