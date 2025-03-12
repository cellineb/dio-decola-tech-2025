import { Component, Inject, OnDestroy, OnInit } from '@angular/core';
import { ICLientService } from '../../services/api-client/clients/iclients.service';
import { SERVICES_TOKEN } from '../../services/service.token';
import { ClientsService } from '../../services/api-client/clients/clients.service';
import { SnackbarManagerService } from '../../services/snackbar-manager.service';
import { ISnackbarManagerService } from '../../services/isnackbar-manager.service';
import { Subscription } from 'rxjs';
import { ClientModelTable } from '../client.models';
import { Router } from '@angular/router';
import { ClientTableComponent } from '../components/client-table/client-table.component';

@Component({
  selector: 'app-list-clients',
  imports: [ClientTableComponent],
  templateUrl: './list-clients.component.html',
  styleUrl: './list-clients.component.scss',
  providers: [
    { provide: SERVICES_TOKEN.HTTP.CLIENT, useClass: ClientsService },
    { provide: SERVICES_TOKEN.SNACKBAR, useClass: SnackbarManagerService }
  ]
})
export class ListClientsComponent implements OnInit, OnDestroy {

  private httpSubscriptions: Subscription[] = []

  clients: ClientModelTable[] = []

  constructor(
    @Inject(SERVICES_TOKEN.HTTP.CLIENT) private readonly httpService: ICLientService,
    @Inject(SERVICES_TOKEN.SNACKBAR) private readonly snackBarManager: ISnackbarManagerService,
    private readonly router: Router
  ) { }

  ngOnInit(): void {
    this.httpSubscriptions.push(this.httpService.list().subscribe(data => this.clients = data))
  }
  ngOnDestroy(): void {
    this.httpSubscriptions.forEach(s => s.unsubscribe())
  }

  update(client: ClientModelTable) {
    this.router.navigate(['clients/edit-client', client.id])
  }

  delete(client: ClientModelTable) {
    this.httpSubscriptions.push(
      this.httpService.delete(client.id).subscribe(_ => this.snackBarManager.show(`O cliente ${client.name} foi excluido com sucesso`))
    )
  }

}