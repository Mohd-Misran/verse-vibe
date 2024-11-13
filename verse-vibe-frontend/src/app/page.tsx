import Header from './components/common/header/Header';
import { Fragment } from 'react';
import ThemeWrapper from './theme/ThemeWrapper';

export default function Home() {
  return (
    <Fragment>
      <ThemeWrapper>
        <Header />
      </ThemeWrapper>
    </Fragment>
  );
}
