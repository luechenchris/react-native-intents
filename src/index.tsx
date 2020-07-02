import { NativeModules } from 'react-native';

type IntentsType = {
  getExtras(): Promise<Object>;
  send(app: String): Promise<Boolean>;
};

const { Intents } = NativeModules;

export default Intents as IntentsType;
