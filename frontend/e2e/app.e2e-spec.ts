import { ImobiliarePage } from './app.po';

describe('imobiliare App', () => {
  let page: ImobiliarePage;

  beforeEach(() => {
    page = new ImobiliarePage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
