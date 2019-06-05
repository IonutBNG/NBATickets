import {Component, ElementRef, OnDestroy, OnInit} from '@angular/core';
import {GameService} from "../services/game.service";
import {PopupService} from "../services/popup-service/popup.service";
import {Game} from "../tickets-model/game";

@Component({
  selector: 'app-popup',
  templateUrl: './popup.component.html',
  styleUrls: ['./popup.component.scss']
})
export class PopupComponent implements OnInit, OnDestroy {

  element: any;

  constructor(private gameService: GameService,
              private popupService: PopupService,
              private el: ElementRef) {
    this.element = el.nativeElement;
  }

  private name: string;
  private spots: number;
  private game: Game;

  ngOnInit() {
    this.popupService.currentGame.subscribe(newGame => this.game = newGame);
  }

  private add(name: string, spots: number) {
    this.gameService.addTransaction(this.game, name, spots).subscribe(res => console.log(res));

  }

  ngOnDestroy(): void {
    this.element.remove();
  }
}
